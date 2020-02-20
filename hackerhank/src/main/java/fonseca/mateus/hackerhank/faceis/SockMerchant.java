package fonseca.mateus.hackerhank.faceis;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class SockMerchant {
	
	static int sockMerchant(int n, int[] ar) {
		Map<Integer, Integer> map = new HashMap<>();
		IntStream
			.range(0, ar.length)
			.forEach(i -> {
				map.compute(i, (k, v) -> v == null ? 1 : v + 1);
			});
		return map.values().stream().map(v -> v / 2).reduce((acc, v) -> acc + v).get();
    }

}
