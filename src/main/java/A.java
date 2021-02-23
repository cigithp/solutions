/**
 * Singleton class and various versions
 *
 *
 * When to use static methods ??
 *
 * When you have code that can be shared across all instances of the same class, put that portion of code into static method.
 * They are basically used to access static field(s) of the class.
 *
 *                              Instance method vs Static method
 *
 * Instance method can access the instance methods and instance variables directly.
 * Instance method can access static variables and static methods directly.
 * Static methods can access the static variables and static methods directly.
 * Static methods can’t access instance methods and instance variables directly. They must use reference to object.
 * And static method can’t use this keyword as there is no instance for ‘this’ to refer to.
 *
 *
 *
 */

public class A {
    private static A a;
    private A(){} // private constructor

    /**
     * version 1 : getInstance() returns single instance of A
     * however, still not singleton because multiple threads can
     * create multiple instances
     * @return
     */
    private static A getInstance_1() {
        if(a == null)
            a = new A();
        return a;
    }

    /**
     * version 2: add a synchronized keyword
     * ensure only single instance even in multi-threaded environment
     * but not performant
     * @return
     */
    private static synchronized A getInstance_2() {
        if(a == null)
            a = new A();
        return a;
    }

    /**
     * version 3: Double-checked locking mechanism
     *
     * in addition to checking static field twice use
     * synchronized(A.class) => synchronised on the class name
     * @return
     */
    private static A getInstance_3() {
        if(a == null) {
            synchronized(A.class) {
                if(a == null) {
                    a = new A();
                }
            }
        }
        return a;
    }
}
