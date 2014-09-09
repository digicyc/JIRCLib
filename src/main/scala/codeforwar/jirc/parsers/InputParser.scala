package codeforwar.jirc.parsers

import codeforwar.jirc.irc.msg._

/**
 * Parse the Input Stream messages.
 */
object InputParser {
  val PRIVMsg = """:(.*)!(.*) PRIVMSG (.*) :(.*)\r\n""".r
  val PINGMsg = """PING :(.*)\r\n""".r

  def parseInput(data: String): Option[IRCCmd] = {
    // prefix, command, params
    if (data.length < 2)
      None
    else {
      data match {
        case PRIVMsg(sender, host, recv, msg) =>
          Option(IRCPrivMSG(sender, host, recv, msg))
        case PINGMsg(pingHost) =>
          Option(IRCPing(pingHost))
      }
    }
  }
}
