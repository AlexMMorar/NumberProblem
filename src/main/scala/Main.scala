object Main {

     def main(args: Array[String]): Unit = {
        if(args.length != 1)
            println("Please provide one argument! (preferably to be number)")
        else
            DigitNumber.run(args(0))
    }

}
