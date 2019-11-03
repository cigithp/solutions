import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream of strings as input.
 * '1,2,3,4,5'
 * '1,empty,EMpty,2,3'
 *
 * return Pair object where successes = sum of numbers, failures = count of 'empty' strings
 *
 *
 *
 */

//TODO: check how to deal with Stream.Builder and Stream class in java
public class StreamString {

    static class Pair{
        long successes;
        long failures;

        public Pair(long successes, long failures) {
            this.successes = successes;
            this.failures = failures;
        }

        public long getSuccesses() {
            return successes;
        }

        public void setSuccesses(long successes) {
            this.successes = successes;
        }

        public long getFailures() {
            return failures;
        }

        public void setFailures(long failures) {
            this.failures = failures;
        }
    }

    private static Pair processStream(Stream<String> input) {
        return input
                .map(x -> {
                   String[] splitter = x.split(",");
                   long failure = 0L, success = 0L;
                   Pair p = new Pair(success, failure);
                   for(String s : splitter) {
                       if(s.equalsIgnoreCase("empty"))
                           failure++;
                       else
                           success += Long.parseLong(s);
                   }
                   p.setFailures(failure);
                   p.setSuccesses(success);
                   return p;
                }).collect(Collectors.toList()).get(0);
    }

    public static void main(String[] args) {
        Stream.Builder<String> ss = new Stream.Builder<>() {
            @Override
            public void accept(String s) {

            }

            @Override
            public Stream<String> build() {
                return null;
            }
        };
        StreamString.processStream(ss.build());

    }





}
