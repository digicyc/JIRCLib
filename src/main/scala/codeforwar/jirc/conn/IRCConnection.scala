package codeforwar.jirc.conn

import java.net.{Socket, InetAddress}
import java.io._

import akka.actor.{Actor, ActorLogging}
import codeforwar.jirc.irc.msg.IRCCmd
import codeforwar.jirc.parsers.InputParser

/**
 * Handle our Socket connection.
 */
case class IRCConnection(serverAddress: String, serverPort: Int) extends Actor with ActorLogging {

  /**
   * Create the connection and start dumping Input to InputActor and Listen to Output Actors.
   * @param nick
   * @param user
   * @param realname
   */
  def connect(nick: String, user: String, realname: String) {
    val socket = new Socket(InetAddress.getByName(serverAddress), serverPort)
    val outStream =
      new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream)))
    val input = new BufferedReader(new InputStreamReader(socket.getInputStream))

    rawWrite("NICK " + nick)
    rawWrite("USER " + user + " 8 * : " + realname)

    while(true) {
      val msgType: Option[IRCCmd] = InputParser.parseInput(input.readLine())
    }


    def rawWrite(data: String) {
      outStream.write(data + "\r\n")
    }
  }

  def receive = {
    case intput: InputStream => {
      // Handle Msgs from Server
    }
  }
}

