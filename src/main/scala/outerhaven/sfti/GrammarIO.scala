package outerhaven.sfti

/**
 * grammar examples for i/o
 */
class GrammarIO extends GrammarExample {
  def entrance() {
    println("### grammar examples for i/o")
    val name = readLine("Input your name:")
    printf("Hello %s\n", name)
    print("please input your age:")
    val age = readInt()
    printf("Hello %s, your salary is %d\n", name, age)
    
  }
}