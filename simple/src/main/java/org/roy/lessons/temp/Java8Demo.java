package org.roy.lessons.temp;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by lilei on 16/9/21.
 */
public class Java8Demo {

    public void startAThreadBefore() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("create a new thread");
            }
        });
        t.start();
    }

    public void startAThreadNow() {
        new Thread(() -> System.out.println("create a new thread")).start();
    }

    public void compareBefore() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "ae"));
        personList.add(new Person(5, "de"));
        personList.add(new Person(3, "fe"));

        // 按照年龄升序排列
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        System.out.println(personList);
    }

    public void compareNow() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "ae"));
        personList.add(new Person(5, "de"));
        personList.add(new Person(3, "fe"));

        // 按照年龄升序排列
        Collections.sort(personList, (o1, o2) -> Integer.compare(o1.getAge(), o2.getAge()));
        System.out.println(personList);
    }

    public void countNumBefore() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "ae"));
        personList.add(new Person(5, "de"));
        personList.add(new Person(3, "fe"));
        long count = 0;
        for (Iterator<Person> it = personList.iterator(); it.hasNext(); ) {
            Person p = it.next();
            if (p.getAge() < 10)
                count++;
        }
        System.out.println("count is:" + count);
    }

    public void countNumNow() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "ae"));
        personList.add(new Person(5, "de"));
        personList.add(new Person(3, "fe"));
        long count = personList.stream().filter(p -> p.getAge() < 10).count();
        System.out.println("count is:" + count);
    }

    public void operDemo() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "ae"));
        personList.add(new Person(5, "de"));
        personList.add(new Person(3, "fe"));

        List<Person> filteredList = personList.stream().filter(p -> p.getAge() < 10).collect(Collectors.toList());
        List<String> mappedName = personList.stream().map(p -> p.getName()).collect(Collectors.toList());
        List<String> mappedName2 = personList.stream().map(Person::getName).collect(Collectors.toList());

        personList.stream().forEach(p -> System.out.println(p));
        personList.stream().forEach(System.out::println);

        // 年龄最大的人的姓名
        personList.stream().max((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge())).map(Person::getName).get();

        // 累加年龄之和,平均年龄
        long sum = personList.stream().map(Person::getAge).reduce(0, (acc, ele) -> acc + ele);

        // 小于10岁的人的名称:年龄,逗号连接
        StringBuilder strBuilder = personList.stream().filter(p -> p.getAge() < 10)
                .collect(StringBuilder::new, (sb, ele) -> sb.append(ele.getName()).append(":").append(ele.getAge()).append(","), StringBuilder::append);
        System.out.println(strBuilder.toString());
    }

    public static void main(String[] args) {
        Java8Demo demo = new Java8Demo();
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "ae"));
        personList.add(new Person(5, "de"));
        personList.add(new Person(3, "fe"));

        // 小于10岁的人的名称:年龄,逗号连接
        StringBuilder strBuilder = personList.stream().filter(p -> p.getAge() < 10)
                .collect(StringBuilder::new, (sb, ele) -> sb.append(ele.getName()).append(":").append(ele.getAge()).append(","), (left, right) -> left.append(right));
        System.out.println(strBuilder.toString());

        List<Person> personList1 = personList.stream().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        // 并行流
        List<Person> personList2 = personList.parallelStream().filter(p -> p.getAge() < 10).collect(Collectors.toList());

        // list转成map
        Map<String, Person> personMap = personList.stream().collect(Collectors.toMap(p -> p.getName() + p.getAge(), Function.identity()));

        HashMap<String,Person> personHashMap = personList.stream().collect(HashMap::new,(acc,ele)->acc.put(ele.getName()+ele.getAge(),ele),HashMap::putAll);
        System.out.println(personHashMap);

        Map<String,Person> pMap = new HashMap<>();
        for(Person p:personList){
            String key = p.getName()+p.getAge();
            pMap.put(key,p);
        }


    }


    public static class Person {
        int age;
        String name;

        public Person() {
        }

        public Person add(Person p) {
            return p;
        }

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


}
