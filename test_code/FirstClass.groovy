class FirstClass {
    public static void main(String[] args) {
        def sc = new SecondClass();

        sc.first_name = "Ian"
        sc.last_name = "Bonnycastle"

        println(sc)

        def tc = new ThirdClass();

        tc.testout()

        println(tc instanceof BaseInterface)

        def range = 1..5

        println(range)
        println(range.get(2))

        
    }
}