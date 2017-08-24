package outerhaven.algorithm.basic.string

object StringAlgorithm {
  def kmpFastFind( target: String, pattern: String ): Int = {
    val failFunction: Array[Int] = failureFunction(pattern) 
    val m = pattern.size
    val n = target.size
    var t, p = 0
    while ( t < n && p < m  ){
      if ( pattern(p).equals(target(t)) ){
        p += 1
        t += 1
      }else if ( p == 0 ) {
        t += 1
      }else {
        p = failFunction(p-1) + 1
      }
    }
    
    if ( p < m ){
      -1
    }
    t - m
  }
  
  def failureFunction( pattern: String ): Array[Int] = {
    val result = new Array[Int](pattern.size)
    result(0) = -1
    for ( i <- 1 to result.length -1 ){
      var j = result(i-1)
      while ( ! pattern(j+1).equals(pattern(i)) && j >= 0){
        j = result(j)
      }
      if ( pattern(j+1).equals(pattern(i)) ){
        result(i) = j + 1
      }else{
        result(i) = -1 
      }
    }
    result
  }
}