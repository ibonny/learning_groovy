class SecondClass {
    String first_name
    String last_name

    String toString() {
        return String.format("%s %s", first_name, last_name)
    }
}