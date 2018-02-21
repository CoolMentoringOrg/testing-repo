package com.example.part_1;

import com.example.annotations.Complexity;
import rx.Observable;

import java.util.function.Function;

import static com.example.annotations.Complexity.Level.*;

public class Part1ExtraExercises_Optional {

    @Complexity(EASY)
    public static Observable<String> flattenObservablesOrdered(Observable<Observable<String>> input) {
        // TODO: flatten map ordered strings to character
        // HINT: rx.Observable#concatMap
        // input.flatMap(stream -> stream);
        return input.concatMap(Function.<Observable<String>>identity()::apply);
    }

    /**
     * Write a program that transform the numbers from 1 to 100 to String representation.
     * But:
     * * For multiples of three map to “Fizz” instead of the number.
     * * For the multiples of five map to “Buzz”.
     * * For numbers which are multiples of both three and five map to “FizzBuzz”.
     * * For the case when non of above statements are true return string representation of a number
     *
     * @param input Input of numbers from 1 to 100
     * @return Observable with mapped numbers
     */
    @Complexity(HARD)
    public static Observable<String> fizzBuzz(Observable<Integer> input) {

        //        return input
        //                .map(i -> new IndexedWord(i, ""))
        //                .map(iw -> iw.getIndex() % 3 == 0 ? new IndexedWord(iw.getIndex(), "Fizz") : iw)
        //                .map(iw -> iw.getIndex() % 5 == 0 ? new IndexedWord(iw.getIndex(), iw.getWord() + "Buzz") : iw)
        //                .map(iw -> iw.getWord().isEmpty() ? String.valueOf(iw.getIndex()) : iw.getWord());

        return input.map(
                i -> i % 15 == 0 ? "FizzBuzz" :
                        i % 3 == 0 ? "Fizz" :
                                i % 5 == 0 ? "Buzz" :
                                        i.toString()
        );
    }
}
