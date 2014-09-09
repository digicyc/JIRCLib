package codeforwar.jirc.irc.msg

/**
 * 
 * Created with IntelliJ IDEA.
 * User: Aaron Allred
 */
case class IRCPrivMSG(sender: String, hostname: String, recipient: String, msg: String) extends IRCCmd