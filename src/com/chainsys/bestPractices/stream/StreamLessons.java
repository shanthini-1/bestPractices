package com.chainsys.bestPractices.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.BaseStream;
import java.util.stream.LongStream;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
// Stream is a sequence elements of element computed on demand.
// Stream supports sequential and parallel aggregations operations
// Stream is not a collection.
// Stream is not a data Structure
// Streams cannot be iterated directly.
// Streams cannot accessed using index value.
// A Stream represents single use sequence of data
// A Stream should be operated on only once
// Stream is the derived from collection
// they are not substitutions for collections

public class StreamLessons {
	public static void demoA() {
		Stream s1 = Stream.empty(); // creating empty stream
		Stream<Integer> intStream = Stream.of(10, 20, 30, 40, 40, 50, 60, 70, 80);
//		long count = intStream.count();
//		System.out.println("result count: "+ count);
//		stream has already been operated upon or closed
//		A Stream represents single use sequence of data
//		A Stream should be operated on only once
//		int value = intStream.findFirst().get(); 
//		findFirst() returns object of type Optional
//		get() of optional returns the first value
//		System.out.println("value :" + value);
//		System.out.println("instream :" + intStream.toList());
//		System.out.println("intStream[0] ");     // -error
	}

	public static void demoB() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			list.add(i);
		}
//		List<Integer> list2 = Arrays.asList(5,10,15,20,25,30);
		Stream<Integer> intStreamA = list.stream();
		List<Integer> evenNumbers = intStreamA.filter(i -> i % 2 == 0).collect(Collectors.toList()); // collect() -
																										// returns
																										// acollection
		System.out.println(evenNumbers);

	}

	public static void demoC() {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		Integer sum = integers.stream().reduce(0,(a, b) -> a + b);
//		a= 0
		System.out.println(sum);
//		Reduction of objects/elements - returning a single value 
//		by performing an operation on elements of a collection
	}

	public static void demoD() {
		IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
//		System.out.println(intStream.count());
		System.out.println(intStream.sum());
		LongStream longStream = LongStream.of(2234325532l, 3425436849214l);
		System.out.println(longStream.sum());
		DoubleStream doublestream = DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0);
		System.out.println(doublestream.sum());
	}

	public static void demoE() {
		Supplier<Stream<Integer>> intstream = () -> Stream.of(10, 2, 3, 4, 5);
		System.out.println("Count: " + intstream.get().count());
		System.out.println("First: " + intstream.get().findFirst().get());
		System.out.println("List: " + intstream.get().toList());
//		get() on the supplier creates a new stream everytime
	}

	public static void demoF() {
		Stream<Integer> intStream = IntStream.of(1, 2, 3, 4, 5).boxed();
//		boxed() - Converting primitive type to object type
		System.out.println(intStream.findFirst().get());
	}

	public static void demoG() {
		Stream<Integer> streamOne = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		streamOne.forEach(p -> System.out.println(p));
		Stream<Integer> streamTwo = Stream.of(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		streamTwo.forEach(p -> System.out.println(p));
	}

	public static void demoH() {
		Stream<Integer> randomNumbers = Stream.generate(() -> (new Random()).nextInt(100));

		randomNumbers.limit(20).forEach(System.out::println);
	}

	public static void demoI() {
		//
		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Vijay");
		memberNames.add("Arjun");
		memberNames.add("Rajini");
		memberNames.add("Ajith");
		memberNames.add("Suriya");
		memberNames.add("Anjali");
		memberNames.add("Kamal");
		memberNames.add("Vikram");
		memberNames.stream().filter((s) -> s.startsWith("K")).forEach(System.out::println);
//		filter returns a stream - Intermediate Operations
		memberNames.stream().filter((s) -> s.startsWith("V")).map(String::toUpperCase).forEach(System.out::println);
//		The map() intermediate operation converts each element in the stream into
//		another object via the given function.
		memberNames.stream().sorted().map(String::toUpperCase).forEach(System.out::println);
	}

	public static void demoJ() {
		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Vijay");
		memberNames.add("Arjun");
		memberNames.add("Rajini");
		memberNames.add("Ajith");
		memberNames.add("Suriya");
		memberNames.add("Anjali");
		memberNames.add("Kamal");
		memberNames.add("Vikram");
		memberNames.add("Arun");
		memberNames.add("Sanjay");
		memberNames.add("Amala");
		memberNames.add("Karthick");
		memberNames.add("Vinay");
//		Terminal operations - Terminal operations return a result of a certain type after processing all the stream elements.
		List<String> memNamesInUppercase = memberNames.stream().sorted().map(String::toUpperCase)
				.collect(Collectors.toList());
//		System.out.print(memNamesInUppercase);
		boolean matchedResult = memberNames.stream().anyMatch((s) -> s.startsWith("A"));

		System.out.println(matchedResult); // true

		matchedResult = memberNames.stream().allMatch((s) -> s.startsWith("A"));

		System.out.println(matchedResult); // false

		matchedResult = memberNames.stream().noneMatch((s) -> s.startsWith("A"));

		System.out.println(matchedResult); // false
		long totalMatched = memberNames.stream().filter((s) -> s.startsWith("A")).count();

		System.out.println(totalMatched);
		Optional<String> reduced = memberNames.stream().reduce((s1, s2) -> s1 + "," + s2);

		reduced.ifPresent(System.out::println);
	}

	public static void demoK() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 100; i++) {
			list.add(i);
		}
//		System.out.println(list.parallelStream().findFirst().get());
//		System.out.println(list.parallelStream().findAny().get());
		
		Stream.of("one", "two", "three", "four")
		.peek(e -> System.out.println("before value: " + e))
	            .filter(e -> e.length() > 3)
	             .peek(e -> System.out.println("Filtered value: " + e))
	              .map(String::toUpperCase)
	              .peek(e -> System.out.println("Mapped value: " + e))
	              .collect(Collectors.toList());
	}

	public static void demoL() {
		List<String> memberNames = new ArrayList<String>();
		memberNames.add("Arjun");
		memberNames.add("Rajini");
		memberNames.add("Ajith");
		memberNames.add("Suriya");
		memberNames.add("Arjun");
		memberNames.add("Kamal");
		memberNames.add("Kamal");
		memberNames.add("Arun");
		memberNames.add("Sanjay");
//		memberNames.stream().distinct().forEach(System.out::println);

		/*
		 * peek() is an intermediate operation and we didn't apply a terminal operation
		 * to the pipeline
		 */
//		memberNames.stream().peek(e -> System.out.println(e)).collect(Collectors.toList());
//	    memberNames.stream().peek(System.out::println).collect(Collectors.toList()); //same to line187
//		memberNames.stream().skip(5).forEach(System.out::println);
		Stream<Integer> streamOne = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
//		streamOne.skip(2).forEach(System.out::println);
		streamOne.peek(System.out::println).collect(Collectors.toList());
//		streamOne().forEach(System.out::println);

	}

	public static void demoM() {
		/*
		 * peek() does not manipulate the element inside stream
		 */
		Stream.of("one", "two", "three", "four").peek(e -> e.toUpperCase()).forEach(System.out::println);
		/*
		 * map() will manipulate the element inside the stream
		 */
		Stream.of("one", "two", "three", "four").map(e -> e.toUpperCase()).forEach(System.out::println);
	}

	public static void demoN() {
		 //  peek() can be useful in altering the inner state of an element
		// 	 without replacing the element
		 Stream<Emp> empStream = Stream.of(new Emp(100,"Alice"), new Emp(101,"Bob"), new Emp(102,"Chuck"));
		 empStream.peek(e -> e.setName(e.getName().toUpperCase()))
		  .forEach(System.out::println);
//		 Stream<Emp> empStreamA = Stream.of(new Emp(100,"Alice"), new Emp(101,"Bob"), new Emp(102,"Chuck"));
//		 empStream.peek(e -> e.toString())
//		  .forEach(System.out.println(e -> e.getId()));
	}
}

class Emp {
	private int id;
	private String name;

	public Emp(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String toString() {
		return getName();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
