import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FPTest {

  public static void main(String[] args) {
    List<Integer> numList = new ArrayList<Integer>(
        List.of(1, 3, 5, 9, 8, 7, 6, 10));

    if (false) {
      PrintIntList(numList);

      System.out.println("\nPrint Even list:");
      PrintEvenList(numList);

      System.out.println("\nPrint Square list:");
      PrintSquareList(numList);
    } else {
      TestOptional();
    }
  }

  private static void PrintIntList(List<Integer> numList) {
    // numList.stream().forEach(FPTest::Print);
    numList.stream().forEach(System.out::println); // Method Reference
  }

  private static void PrintEvenList(List<Integer> numList) {
    numList.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
  }

  private static void PrintSquareList(List<Integer> numList) {
    numList.stream().map(n -> n * n).forEach(System.out::println);
  }

  private static void TestOptional() {
    List<String> fruits = List.of("apple", "banana", "mango");
    Optional<String> optional = 
        fruits.stream().filter(f -> f.startsWith("c")).findFirst();

    System.out.println(optional);
    System.out.println(optional.isEmpty());
    System.out.println(optional.isPresent());
    System.out.println(optional.orElseGet(() -> "none"));

    Optional<String> nullableFruit = Optional.ofNullable("banana");
    System.out.println(nullableFruit);
    Optional<String> emptyOptional = Optional.empty();
    System.out.println(emptyOptional);
  }

  private static void Print(int num) {
    System.out.println(num);
  }
}
