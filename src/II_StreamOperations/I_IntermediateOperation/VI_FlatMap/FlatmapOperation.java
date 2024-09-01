package II_StreamOperations.I_IntermediateOperation.VI_FlatMap;

import java.util.Arrays;
import java.util.List;

public class FlatmapOperation {
	/* flatMap() trong stream API dùng để chuyển đổi mỗi phần tử trong stream
	thành 1 stream khác và sau đó "phẳng hóa" các stream con này thành 1 stream
	duy nhất, dùng để xử lí các cấu trúc dữ liệu lồng nhau như là danh sách các
	danh sách List<List<R>>
	* */
	
	public static void main(String[] args) {
		// Giả sử bạn có 1 danh sách các danh sách số nguyên và bạn muốn kết
		// hợp tất cả các số thành 1 danh sách duy nhất
		List<List<Integer>> listOfLists = Arrays.asList(
			Arrays.asList(1,2,3),
			Arrays.asList(4,5),
			Arrays.asList(6,7,8,9)
		);
		
		List<Integer> allNumbers = listOfLists.stream()
				.flatMap(list -> list.stream())
				.toList();
		System.out.println(allNumbers);
		// [1, 2, 3, 4, 5, 6, 7, 8, 9]
	}
}
