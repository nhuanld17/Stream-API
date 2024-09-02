package II_StreamOperations.I_IntermediateOperation.XVI_ParallelOperation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

public class ParallelOperation {
	public static void main(String[] args) {
		// Sử dụng parallel() để tính tổng
		List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		int sum = integerList.parallelStream()
				.mapToInt(num -> num.intValue())
				.sum();
		System.out.println("SUM: " + sum);
		// SUM: 55
		
		// Kiểm tra hiệu suất giữa Stream và Parallel Stream
		long n = 10_000_000;
		
		// Tính toán với Stream tuần tự
		long startTime = System.currentTimeMillis();
		long sequentialSum = LongStream.rangeClosed(1, n).sum();
		long endTime = System.currentTimeMillis();
		
		System.out.println("Sequential Sum: " + sequentialSum + " in " +(endTime - startTime) + " ms");
		// Sequential Sum: 50000005000000 in 32 ms
		
		// Tính toán với Parallel Stream
		startTime = System.currentTimeMillis();
		long parallelSum = LongStream.rangeClosed(1,n).parallel().sum();
		endTime = System.currentTimeMillis();
		System.out.println("Parallel Sum: " + parallelSum + " in " +(endTime - startTime) + " ms");
		// Parallel Sum: 50000005000000 in 15 ms
	}
}
