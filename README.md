# java8-workshop

This workshop will go through all new features brought by Java 8, with code snippets and test driven demonstration.

## Java 8 new features

- Default Methods for Interfaces
- Lambda expressions
- Functional Interfaces
- Optionals
- Streams & Parallel Streams
- Date API

## Workshop

- [Default Methods and Functional Interfaces](#default-methods-and-functional-interfaces) _15 minutes_
- [Lambda expressions](#lambda-expressions) _15 minutes_
- [Optionals](#optionals) _15 minutes_
- Exercise : Enable Lambda using @FunctionalInterface _15 minutes_
- [Collection and Map API](#collection-and-map-api) _20 minutes_
- break ? _10 minutes_
- [Stream API](#stream-api) _45 hour_
- Exercise : Find top 5 accounts sorted by balance _15 minutes_
- [Date API](#date-api) _30 minutes_

Duration : 3 hours

## Topics

### Default Methods and Functional Interfaces

- Default Methods

```java
public interface CalculatorDefaultMethod {
    default double add(double a, double b) {
        return a + b;
    }
}
```

***

_Best practices :_

Don't overuse Default Methods. Extending different interfaces with the same default method can be problematic.
You may end up with a compile-time error : `interface ... inherits unrelated default for method`

```java
public interface CarDriver {
    String go();
    default void drive() {}
}

public interface TaxiDriver {
    String go();
    default void drive() {}
}

public interface BusDriver extends CarDriver, TaxiDriver {
    // you have to override the default method.
    default void drive() {
        TaxiDriver.super.driver();
    }
}
```

***

- @FunctionalInterface

```java
@FunctionalInterface
public interface CalculatorFunctional<T> {
    T calculate(T a, T b);
}

```

***

_Best practices :_

Avoid overloading methods with Functional Interfaces. 
As they are meant to be used dynamically with lambda, we may end up with errors :  `reference to method is ambiguous`

```java
@FunctionalInterface
public interface BusDriver {
    String drive(Callable<String> c) throws Exception;
    String drive(Supplier<String> s);
}

public class BusDriverImpl implements BusDriver {
    @Override
    public String drive(Callable<Bus> c) throws Exception {
    }
    @Override
    public String drive(Supplier<Bus> s) {
    }
}

String result = driver.drive(() -> "bus"); // reference to drive is ambiguous
```

__Rename methods would solve it.__

### Lambda Expressions

- Using Lambda expressions

```java
CalculatorFunctional<Double> anonymous = new CalculatorFunctional<Double>() {
            @Override
            public Double calculate(Double a, Double b) {
                return a + b;
            }
        };

// lambda :
CalculatorFunctional<Double> functional = (a, b) -> a + b;
```

***

_Best practices :_

- Avoid Blocks of Code in Lambda’s Body. Have Lambda Expressions short and self-explanatory, go with _clean code_ way.

```java
value -> { 
    String result = "label " + value; 
    return result; 
};

value -> buildString(value);
private String buildString(String value) {
    String result = "label " + value;
    return result;
};
```

***

- Use method reference when possible.

```java
a -> a.toLowerCase();

String::toLowerCase; // better
```

### Optional

- Optional.isPresent()
- Optional.ifPresent()
- Optional.orElse()
- Optional.orElseGet()
- Optional.orElseThrow()

````java
Optional<String> optional = Optional.of("kong");

optional.isPresent();           // true
optional.ifPresent((s) -> System.out.println(s));
optional.get();                 // "kong"
optional.orElse("fallback");    // "fallback"
optional.orElseThrow(() -> new IllegalStateException("not ok")); // error
````

### Collection and Map API

- collection.forEach()

```java
Consumer<User> consumer = user -> nameList.add(user.getLastname() + " " + user.getFirstname());
users.forEach(consumer);
```

***

- collection.removeIf()

```java

Predicate<User> predicate = user -> user.getFirstname().contains(firstname);
users.removeIf(predicate);
```

***

- collection.replaceAll()

````java
UnaryOperator<String> unaryOperator = e -> "Full name : " + e + " ";
userNames.replaceAll(unaryOperator);
````

***

- collection.sort()

````java
Comparator<User> comparator = Comparator.comparing(User::getNationality);
users.sort(comparator);

Comparator<User> comparator = Comparator.comparing(User::getNationality);
Stream<User> nameStream =  users.stream().sorted(comparator);

Comparator<User> comparator = Comparator.comparing(User::getNationality);
Stream<User> nameStream =  users.parallelStream().sorted(comparator);
````

***

- map.getOrDefault()

````java
usersById.getOrDefault(id, kong());
````

***

- map.putIfAbsent()

````java
usersById.putIfAbsent(id, kong());

````

***

- map.merge()

````java
BiFunction<User, User, User> remappingFunction = (oldVal, newVal) -> {
    oldVal.setFirstname(newVal.getFirstname());
    return oldVal;
};
usersById.merge(id, userWithNewData, remappingFunction);
````

***

- map.computeIfPresent()

````java
BiFunction<Integer, User, User> remappingFunction = (key, val) -> {
    val.setFirstname("Kong");
    return val;
};
usersById.computeIfPresent(1, remappingFunction);
````

### Stream API

- stream().sort()
- stream().collect()
- stream().filter()

```java
accounts.stream()
        .filter(a -> a.getUser().getAge() < MAJOR_MIN_AGE)
        .collect(Collectors.toSet());

accounts.parallelStream()
        .filter(a -> a.getUser().getAge() >= MAJOR_MIN_AGE)
        .sorted(Comparator.comparing(Account::getBalance))
        .collect(Collectors.toList());
```

***

- stream().compare()

```java
accounts.stream()
        .min(Comparator.comparing(Account::getBalance))
        .get();

accounts.stream()
        .max(Comparator.comparing(Account::getBalance))
        .get();
```

***

- stream().flatMap()

```java
listOfList.stream()
        .flatMap(List::stream)
        .collect(toList());
```

***

- stream().reduce()

```java
accounts.stream()
        .mapToLong(Account::getBalance)
        .reduce(0, Long::sum);
```

***

- stream().summaryStats()

```java
accounts.stream()
        .mapToInt(Account::getBalance)
        .summaryStatistics();
```

***

- Collectors.joining()

```java
users.stream()
    .map(user -> user.getFirstname() + " " + user.getLastname())
    .collect(Collectors.joining(", ", "Names: ", ""));
```

***

- Collectors.groupBy

```java
accounts.stream()
        .collect(Collectors.groupingBy(Account::getCountry));
```

***

- Collectors.partitioning()

```java
accounts.stream()
        .collect(Collectors.partitioningBy(a -> a.getBalance() >= minLimit));
```

***

- Collectors.ToMap()

```java
users.stream()
    .collect(Collectors.toMap(User::getUid, u -> u));
```

### Date API

- LocalDate
- LocalTime
- LocalDateTime
- ZonedDateTime

````java
public LocalDate Date_20190618 = LocalDate.of(2019, 5, 28);

public LocalTime Time_17070350 = LocalTime.of(17, 7, 3, 500000000);

public LocalDateTime DateTime_20190528_17070350 = 
    LocalDateTime.of(2019, 5, 28, 17, 7, 3, 500000000);

public ZonedDateTime DateTimeZone_20190528_17070350 = 
    ZonedDateTime.of(DateTime_20190528_17070350, ZoneId.of("Europe/Paris"));
````
