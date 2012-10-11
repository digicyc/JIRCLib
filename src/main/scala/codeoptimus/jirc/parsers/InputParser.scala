package codeoptimus.jirc.parsers

import codeoptimus.jirc.ircmsgs.{IRCNotice, IRCPrivMSG}

/**
 * 
 * Created with IntelliJ IDEA.
 * User: Aaron Allred
 */
class InputParser {
  def parseInput(msg: String): (String, String) = {
    msg match {
      case pMsg: IRCPrivMSG =>
      case notice: IRCNotice =>
    }
  }
}
