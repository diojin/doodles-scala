package outerhaven.algorithm.misc

object BitmapAlgorithm extends App {

  val MAX_VALUE = 99999999
  
  val BITS_PER_WORD = 32
  
  val bitmap = new Array[Int](MAX_VALUE/BITS_PER_WORD)
 
  findDuplication(mockupData)
  
  println("### try to get the last 2th bit of 6")
  
  // since 6 is 0110 as decimal number, it shoulds return 1
  println(getCertainBit(6, 2))      // 1
  
  // since 5 is 0101 as decimal number, it shoulds return 1
  println(getCertainBit(5, 2))      // 0
  
  def findDuplication( dataset : Array[Int] ) {
    for ( i <- 0 to bitmap.length - 1 ){
      bitmap(i) = 0
    }
    
    for ( i <- 0 to dataset.length - 1 ){
      if ( getBit(dataset(i)) == 0 ){
        setBit(dataset(i))
      }else{
        println("find duplication: " + dataset(i))
      }
    }
  }
  
  /**
   * return the index of array for a word, 
   * knows as its word offset
   */
  def wordOffset( number : Int): Int = {
    number / BITS_PER_WORD
  }
  
  /**
   * return the bit offset of integer which represents the word
   */
  def bitOffsetOfWord( number : Int ) : Int = {
    number % BITS_PER_WORD
  }
  
  /**
   * set to 1 the bit of integer, which represents the word
   */
  def setBit( number: Int ) {
    bitmap(wordOffset(number)) |= ( 1 << bitOffsetOfWord(number))
  }
  
  /**
   * get the bit of integer, which represents the word
   */
  def getBit( number : Int ) = {
    val bit = bitmap(wordOffset(number)) & ( 1 << bitOffsetOfWord(number) )
    if ( bit != 0 ){
      1
    }else{
      0
    }
  }
  
  /**
   * set to 0 the bit of integer, which represents the word
   */
  def clearBit( number: Int) {
    bitmap(wordOffset(number)) &= ~( 1 << bitOffsetOfWord(number) )
  }
  
  
  /**
   * return the kth bit of input, starting from rear 
   * 6 is 0110
   * getCertainBit(6, 2)				// 1
   * 5 is 0101
   * getCertainBit(5, 2)				// 0
   */
  def getCertainBit( input: Int,  k : Int ) = {
    ( input >> k - 1  ) & 1
  }
  
  def mockupData() = {
    val res = new Array[Int](100)
    for ( i <- 0 to res.length -1 ){
      res(i) = (math.random * 50 ).toInt
    }
    res
  }
}