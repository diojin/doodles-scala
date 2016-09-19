package outerhaven.sfti.doodles

abstract class UndoableAction(var description: String) {
  def undo() : Unit
  def redo() : Unit
}

object DoNothingAction extends UndoableAction("do nothing"){
  override def undo() {}
  override def redo() {}
  
}