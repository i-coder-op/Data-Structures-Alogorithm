package com.questions.string;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionPredicate {
    public static Predicate<String> nameStartingWithPrefix(String prefix){
        Predicate<String> predicate = n->n.startsWith(prefix);
        return predicate;
    }

    public static void main(String[] args) {
        List<String> list = List.of("asda","asdas", "sdfsdf");
        list = list.stream().filter(FunctionPredicate.nameStartingWithPrefix("as")).collect(Collectors.toList());
        System.out.println("");
    }
}
