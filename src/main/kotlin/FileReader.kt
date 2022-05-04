import java.io.File

class FileReader {
    fun getPuzzle1(): List<Int> {
        val url = "src/main/resources/puzzle1.txt"
        var file = File(url).readLines()
        //println(file);
        val inputList = file.map { it.toInt() }

        val length = inputList.size;
        println("length is " + length);
        var measurementPart1 = 0;


        //for (i in inputList.indices){
        //if(i + 1 != 2000){
          //     if( inputList[i] < inputList[i + 1]){
                  // measurementPart1 += 1;
           // }
          // }

          //println(measurementPart1);
       // }


        var measurementPart2 = 0;
        for(i in inputList.indices){
            if(i < 1997){

                var sumA= inputList[i] + inputList[i + 1] + inputList[i + 2 ]
                var sumB= inputList[i + 1] + inputList[i + 2] + inputList[i + 3 ]
                //println(sumA);
                //print(sumB);
                if(sumA < sumB){
                    measurementPart2 += 1;
                }
            }

        }
        println("Answer Part 2: "+ measurementPart2)

       return inputList;


    }

    fun getPuzzle2(): List<List<Any>> {
        val url = "src/main/resources/puzzle2.txt"
        var file = File(url).readLines()
        val inputList = mutableListOf<List<Any>>()
        file.forEach{
            val splittedString = it.split(' ')
            inputList.add(listOf<Any>(splittedString[0], splittedString[1].toInt()))
        }

        var x = 0;
        var y = 0;

        inputList.forEach {
        val direction = it[0] as String
        val amount = it[1] as Int

        when(direction){
            "forward" -> x += amount
            "down" -> y += amount
            "up" -> y -= amount
        }
        }
        val answer = x * y;
        print(answer)
        return inputList
    }

    fun getPuzzle3(): List<List<Int>> {
        val url = "src/main/resources/puzzle3.txt"
        var file = File(url).readLines()
        val inputList = mutableListOf<List<Int>>()
        file.forEach{
            println("Test")
            val charArray = it.toCharArray()
            val intList = charArray.map{it -> it.digitToInt() }
            inputList.add(intList)
        }

        return inputList
    }

    fun getPuzzle4Numbers(): List<Int> {
        val url = "src/main/resources/puzzle4_numbers.txt"
        var file = File(url).readLines()
        var inputs = file[0].split(',')
        return inputs.map { it.toInt() }
    }

    fun getPuzzle4Cards(): List<List<Int>> {
        val url = "src/main/resources/puzzle4_cards.txt"
        var file = File(url).readLines()
        val allNumbers = mutableListOf<Int>()
        file.forEach{
            var splittedString = it.split(' ')
            splittedString.forEach {
                if(!it.isNullOrEmpty()) {
                    allNumbers.add(it.toInt())
                }
            }
        }
        var inputs = mutableListOf<List<Int>>()
        var card = mutableListOf<Int>()
        allNumbers.forEachIndexed { index, i ->
            card.add(i)
            if(card.size >= 25) {
                inputs.add(card)
                card = mutableListOf<Int>()
            }
        }
        return inputs
    }

}