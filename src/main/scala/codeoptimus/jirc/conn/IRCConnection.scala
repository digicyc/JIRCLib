package codeoptimus.jirc.conn

import java.net.{Socket, InetAddress}
import java.io.BufferedWriter

/**
 * Handle our Socket connection.
 * Created with IntelliJ IDEA.
 * User: Aaron Allred
 */
case class IRCConnection(serverAddress: String, serverPort: Int) {
  private val socket = new Socket(InetAddress.getByName(serverAddress), serverPort)
  private lazy val output = new BufferedWriter(socket.getOutputStream())

  def getSocket = socket

  def connect(nick: String, user: String, realname: String) {
    rawWrite("NICK " + nick)
    rawWrite("USER " + user + " 8 * : " + realname)


  }

  def rawWrite(data: String) {
    output.write(data + "\r\n")
  }
}
