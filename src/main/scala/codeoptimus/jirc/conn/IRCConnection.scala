package codeoptimus.jirc.conn

import java.net.{Socket, InetAddress}
import io.BufferedSource

/**
 *
 * Created with IntelliJ IDEA.
 * User: Aaron Allred
 */
case class IRCConnection(val serverAddress: String, val serverPort: Int) {
  val socket = new Socket(InetAddress.getByName(serverAddress), serverPort)
  lazy val input = new BufferedSource(socket.getInputStream()).getLines()

  def getSocket = socket
  def getInput = input
}
