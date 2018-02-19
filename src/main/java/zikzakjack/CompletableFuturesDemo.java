package zikzakjack;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompletableFuturesDemo {

	static List<Shop> shops = Arrays.asList(new Shop("Walmart"), new Shop("Costco"), new Shop("BestBuy"),
			new Shop("ToysRus"));

	public static void main(String[] args) {

		System.out.println("\n********** findPriceAsync **********\n");
		findPriceAsync();

		System.out.println("\n********** findPriceAsyncHandyFactory **********\n");
		findPriceAsyncHandyFactory();

		System.out.println("\n********** findPricesSequential **********\n");
		findPricesSequentialStream("myPhone27S");

		System.out.println("\n********** findPricesParallel **********\n");
		findPricesParallelStream("myPhone27S");

		System.out.println("\n********** findPricesCompletableFuture **********\n");
		findPricesCompletableFuture("myPhone27S");

	}

	private static void findPriceAsync() {
		Shop shop = new Shop("BestBuy");
		long start = System.nanoTime();
		Future<Double> futurePrice = shop.getPriceAsSync("Bread");
		long invocationTime = (System.nanoTime() - start) / 1_000_000;
		System.out.println("Invocation returned after " + invocationTime + " ms...");

		doSomethingElse();

		try {
			double price = futurePrice.get();
			System.out.printf("Price is %.2f %n", price);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		long retrievalTime = (System.nanoTime() - start) / 1_000_000;
		System.out.println("Price returned after " + retrievalTime + " ms...");
	}

	private static void findPriceAsyncHandyFactory() {
		Shop shop = new Shop("BestBuy");
		long start = System.nanoTime();
		Future<Double> futurePrice = shop.getPriceAsSyncHandyFactory("Butter");
		long invocationTime = (System.nanoTime() - start) / 1_000_000;
		System.out.println("Invocation returned after " + invocationTime + " ms...");

		doSomethingElse();

		try {
			double price = futurePrice.get();
			System.out.printf("Price is %.2f %n", price);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		long retrievalTime = (System.nanoTime() - start) / 1_000_000;
		System.out.println("Price returned after " + retrievalTime + " ms...");
	}

	private static void doSomethingElse() {
		System.out.println("Doing SomethingElse too..");
		DelayUtil.delay(1000L);
	}

	public static void findPricesSequentialStream(String product) {
		long start = System.nanoTime();
		List<String> prices = shops.stream()
				.map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
				.collect(toList());
		System.out.println(prices);
		long duration = (System.nanoTime() - start) / 1_000_000;
		System.out.println("Done in " + duration + " msecs");
	}

	public static void findPricesParallelStream(String product) {
		long start = System.nanoTime();
		List<String> prices = shops.parallelStream()
				.map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
				.collect(toList());
		System.out.println(prices);
		long duration = (System.nanoTime() - start) / 1_000_000;
		System.out.println("Done in " + duration + " msecs");
	}

	public static void findPricesCompletableFuture(String product) {
		long start = System.nanoTime();
		List<CompletableFuture<String>> priceFutures = shops.stream()
				.map(shop -> CompletableFuture
						.supplyAsync(() -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product))))
				.collect(toList());
		List<String> prices = priceFutures.stream().map(CompletableFuture::join).collect(toList());
		System.out.println(prices);
		long duration = (System.nanoTime() - start) / 1_000_000;
		System.out.println("Done in " + duration + " msecs");
	}

}

class Shop {
	String name;

	public Shop(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	/**
	 * Synchronous Version
	 * 
	 * @param product
	 * @return
	 */
	public double getPrice(String product) {
		return calculatePrice(product);
	}

	/**
	 * ASynchronous Version
	 * 
	 * @param product
	 * @return
	 */
	public Future<Double> getPriceAsSync(String product) {
		CompletableFuture<Double> futurePrice = new CompletableFuture<>();
		new Thread(() -> {
			try {
				double price = calculatePrice(product);
				// throw new Exception("Product Not Available..");
				futurePrice.complete(price);
			} catch (Exception e) {
				futurePrice.completeExceptionally(e);
			}
		}).start();
		return futurePrice;
	}

	/**
	 * ASynchronous Version using built in factory
	 * 
	 * @param product
	 * @return
	 */
	public Future<Double> getPriceAsSyncHandyFactory(String product) {
		return CompletableFuture.supplyAsync(() -> calculatePrice(product));
	}

	private double calculatePrice(String product) {
		System.out.println("\t" + new Date() + " :: \t" + name + " :: \tStarted calculating price for " + product);
		DelayUtil.delay(2000L);
		double price = new Random().nextDouble() * product.charAt(0) + product.charAt(1);
		System.out.println("\t" + new Date() + " :: \t" + name + " :: \tFinished calculating price for " + product);
		return price;
	}

}

class DelayUtil {
	public static void delay(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			throw new RuntimeException();
		}
	}
}