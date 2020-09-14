package aqs;

import lombok.SneakyThrows;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by randy on 2020/8/20.
 */

@Slf4j
public class CyclicBarrierDemo {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new TourGuideTask());

		executor.execute(new SprintRace(cyclicBarrier, "张三", 0));
		executor.execute(new SprintRace(cyclicBarrier, "李四", 7));
		executor.execute(new SprintRace(cyclicBarrier, "王五", 3));
		executor.execute(new SprintRace(cyclicBarrier, "赵六", 1));
		executor.execute(new SprintRace(cyclicBarrier, "孙七", 7));
		executor.execute(new SprintRace(cyclicBarrier, "周八", 3));

		executor.shutdown();
	}

	private static class SprintRace implements Runnable {
		private CyclicBarrier cyclicBarrier;
		private String name;
		private long readyCostTime;

		private static final String SICK_NAME = "张三";

		private SprintRace(CyclicBarrier cyclicBarrier, String name, long readyCostTime) {
			this.cyclicBarrier = cyclicBarrier;
			this.name = name;
			this.readyCostTime = readyCostTime;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(readyCostTime * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			log.info(name + " 准备起跑");
			if (SICK_NAME.equals(name)) {
				log.info(SICK_NAME + "临时肚子不舒服,退赛");
				Thread.currentThread().interrupt();
			}

			try {
				cyclicBarrier.await();
				log.info(name + " 跑。。。");
			} catch (InterruptedException | BrokenBarrierException e) {
				if (SICK_NAME.equals(name)) {
					log.info(SICK_NAME + "说: 等我恢复元气");
				} else {
					log.info(name + " 无情等待着。。.");
				}
			}
		}
	}

	public static class TourGuideTask implements Runnable {
		@SneakyThrows
		@Override
		public void run() {
			log.info("各就各位——预备——跑,砰!");
			Thread.sleep(1000);
		}
	}
}
