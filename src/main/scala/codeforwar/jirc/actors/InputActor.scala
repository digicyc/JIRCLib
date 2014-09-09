package codeforwar.jirc.actors

import akka.actor.ActorLogging
import akka.actor.Actor
import codeforwar.jirc.conn.IRCConnection
import java.io.{BufferedReader, IOException}
import codeforwar.jirc.parsers.InputParser
import codeforwar.jirc.irc.msg.IRCCmd

/**
 * Our IRC input stream to receive ircmsgs from Server.
 * Created with IntelliJ IDEA.
 * User: Aaron Allred
 */
class InputActor extends Actor with ActorLogging {
  def receive = {
    case ircConn: IRCConnection =>
      while (true) {
        // read from socket and send to Parser.
        try {
          val msgType: Option[IRCCmd] = InputParser.parseInput(input.readLine())
          // Send Event down chain.

        } catch {
          case ioe: IOException =>
            ioe.printStackTrace()
            // Bail out cause Things died.
        }
      }
  }
}
