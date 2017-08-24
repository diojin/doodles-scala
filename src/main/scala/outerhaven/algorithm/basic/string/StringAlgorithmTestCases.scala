package outerhaven.algorithm.basic.string

object StringAlgorithmTestCases extends App {
  kmpFastFindTest
  
  def kmpFastFindTest(){
    println("### start kmp fast find")
    println("pattern is:"+pattern)
    println("target is:" + target1)
    println("result is:" + StringAlgorithm.kmpFastFind(target1, pattern))
  }
  
}