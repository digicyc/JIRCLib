package codeoptimus.jirc.actors

import akka.actor.ActorLogging
import akka.actor.Actor
import java.net.{Socket, InetAddress}
import codeoptimus.jirc.conn.IRCConnection
import java.io.{BufferedReader, IOException}

/**
 * Our IRC input stream to receive ircmsgs from Server.
 * Created with IntelliJ IDEA.
 * User: Aaron Allred
 */
class InputActor extends Actor with ActorLogging {
  def receive = {
    case ircConn: IRCConnection =>
      val socket = ircConn.getSocket
      lazy val input = new BufferedReader(socket.getInputStream())

      while (true) {
        // read from socket and send to Parser.
        try {
          input.readLine()

        } catch {
          case ioe: IOException =>
            ioe.printStackTrace()
            // Bail out cause Things died.
        }
      }
    case "stop" =>
      // Kill Actor and clean up.
  }
}
