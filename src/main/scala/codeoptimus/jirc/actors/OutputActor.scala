package codeoptimus.jirc.actors

import akka.actor.Actor
import akka.actor.ActorLogging
import codeoptimus.jirc.conn.CmdOut

/**
 * 
 * Created with IntelliJ IDEA.
 * User: Aaron Allred
 */
class OutputActor extends Actor with ActorLogging {
  def receive = {
    case cmdOut: CmdOut =>
    case _ => None // Unhandled message sent to me.
  }
}
