import Day02.PUZZLE_INPUT
import Day02.calculateSpreadsheetChecksum
import Day02.maxMinusMin
import Day02.evenlyDivisibleNumbersQuotient

fun main(args: Array<String>) {
    println("Day 02 Pt. One Answer:\t" + calculateSpreadsheetChecksum(PUZZLE_INPUT, maxMinusMin))
    println("Day 02 Pt. Two Answer:\t" + calculateSpreadsheetChecksum(PUZZLE_INPUT, evenlyDivisibleNumbersQuotient))
}

/**
 * See <a href="https://adventofcode.com/2017/day/2">Day 2</a>
 */
object Day02 {

    internal val PUZZLE_INPUT =
            "5048\t177\t5280\t5058\t4504\t3805\t5735\t220\t4362\t1809\t1521\t230\t772\t1088\t178\t1794\n" +
                    "6629\t3839\t258\t4473\t5961\t6539\t6870\t4140\t4638\t387\t7464\t229\t4173\t5706\t185\t271\n" +
                    "5149\t2892\t5854\t2000\t256\t3995\t5250\t249\t3916\t184\t2497\t210\t4601\t3955\t1110\t5340\n" +
                    "153\t468\t550\t126\t495\t142\t385\t144\t165\t188\t609\t182\t439\t545\t608\t319\n" +
                    "1123\t104\t567\t1098\t286\t665\t1261\t107\t227\t942\t1222\t128\t1001\t122\t69\t139\n" +
                    "111\t1998\t1148\t91\t1355\t90\t202\t1522\t1496\t1362\t1728\t109\t2287\t918\t2217\t1138\n" +
                    "426\t372\t489\t226\t344\t431\t67\t124\t120\t386\t348\t153\t242\t133\t112\t369\n" +
                    "1574\t265\t144\t2490\t163\t749\t3409\t3086\t154\t151\t133\t990\t1002\t3168\t588\t2998\n" +
                    "173\t192\t2269\t760\t1630\t215\t966\t2692\t3855\t3550\t468\t4098\t3071\t162\t329\t3648\n" +
                    "1984\t300\t163\t5616\t4862\t586\t4884\t239\t1839\t169\t5514\t4226\t5551\t3700\t216\t5912\n" +
                    "1749\t2062\t194\t1045\t2685\t156\t3257\t1319\t3199\t2775\t211\t213\t1221\t198\t2864\t2982\n" +
                    "273\t977\t89\t198\t85\t1025\t1157\t1125\t69\t94\t919\t103\t1299\t998\t809\t478\n" +
                    "1965\t6989\t230\t2025\t6290\t2901\t192\t215\t4782\t6041\t6672\t7070\t7104\t207\t7451\t5071\n" +
                    "1261\t77\t1417\t1053\t2072\t641\t74\t86\t91\t1878\t1944\t2292\t1446\t689\t2315\t1379\n" +
                    "296\t306\t1953\t3538\t248\t1579\t4326\t2178\t5021\t2529\t794\t5391\t4712\t3734\t261\t4362\n" +
                    "2426\t192\t1764\t288\t4431\t2396\t2336\t854\t2157\t216\t4392\t3972\t229\t244\t4289\t1902"

    /**
     * Solution for 02.1
     */
    internal val maxMinusMin = { numbers: List<Int> ->
        numbers.max()?.minus(numbers.min() ?: 0) ?: 0
    }

    /**
     * Solution for 02.2
     */
    internal val evenlyDivisibleNumbersQuotient = { numbers: List<Int> ->
        var quotient = 0
        var biggerNumber: Int
        var smallerNumber: Int
        numbers.forEachIndexed { index, number ->
            for (otherNumber in (numbers.subList(index + 1, numbers.size))) {
                if (number > otherNumber) {
                    biggerNumber = number
                    smallerNumber = otherNumber
                } else {
                    biggerNumber = otherNumber
                    smallerNumber = number
                }
                if (biggerNumber.rem(smallerNumber) == 0) {
                    quotient = biggerNumber.div(smallerNumber)
                }
            }
        }
        quotient
    }

    internal fun calculateSpreadsheetChecksum(input: String, summationFunction: (List<Int>) -> Int) = input.split("\n")
            .map { line -> line.split("\\s+".toRegex()).map { Integer.parseInt(it) } }
            .sumBy(summationFunction)
}
