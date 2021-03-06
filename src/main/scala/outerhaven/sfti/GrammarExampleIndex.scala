package outerhaven.sfti

/**
 * These are grammar examples from 
 *  Scala for the Impatient 
 *       Cay S. Horstmann
 *              Second printing, June 2013
 *              
 * This is the entrance point
 */
object GrammarExampleIndex extends App {
  println("Hello World")
  val uncatSnippets = new GrammarUncategorizedSnippets
  uncatSnippets.entrance()
  
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
  
  val grammarAdFunc = new GrammarAdvancedFunction
  grammarAdFunc.entrance()
  
  val grammarCollection = new GrammarCollection
  grammarCollection.entrance()
  
  val grammarPatAndCase = new GrammarPatternMatchAndCaseClass
  grammarPatAndCase.entrance()
  
  val grammarAnnotation = new GrammarAnnotation
  grammarAnnotation.entrance()
  
  val grammarXML = new GrammarXML
  grammarXML.entrance()
}


