package outerhaven.sfti

/**
 * These are grammar examples from 
 *  Scala for the Impatient 
 *       Cay S. Horstmann
 *              Second printing, June 2013
 *              
 * This is the entrance point
 */
object GrammarExamples extends App {
  println("Hello World")
  val uncatSnippets = new UncategorizedGrammarSnippets
  uncatSnippets.snippets()
  
  val controlStructAndFunc = new GrammarControlStructureAndFunctions
  controlStructAndFunc.entrance()
  
  val array = new GrammarArray
  array.entrance()
  
  val interoperating = new GrammarJavaInteroperation
  interoperating.entrance()
  
  val grammarMap = new GrammarMap
  grammarMap.entrance()
  
  val grammarTuples = new GrammarTuples
  grammarTuples.entrance()
  
//  val grammarIo = new GrammarIO
//  grammarIo.entrance()
  
  val grammarClass = new GrammarClass
  grammarClass.entrance()
  
  val grammarEnum = new GrammarEnum
  grammarEnum.entrance();

  val grammarPackage = new GrammarPackage
  grammarPackage.entrance()
  
  val grammarInherit = new GrammarInheritance
  grammarInherit.entrance()
  
  val grammarRegex = new GrammarRegExpression
  grammarRegex.entrance()
  
  val grammarOperator = new GrammarOperator
  grammarOperator.entrance()
}


