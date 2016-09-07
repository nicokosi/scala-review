// Create a basic class with a default constructor
class Club {
  def symbol = "♣"
  override def toString = symbol
}
new Club // ♣
// Two clubs are not equal since we did not override 'equals' method:
new Club() == new Club() // false


// Create another class for all card suites with a case class:
case class Suite(symbol: String)
// We can instanciate this class via its constructor:
Suite("♣") // Suite(♣)
// We can also instanciate it via its 'apply' method
new Suite("♣") // Suite(♣)
// We can then compare similar objects since Java's 'equals' is already implemented, on all fields):
Suite("♣") == Suite("♣") // true


// Create an enumeration for all card suites with a "sealed case class":
sealed case class EnumSuite(symbol: String)
object Suites {
  val CLUB = EnumSuite("♣")
  val HEART = EnumSuite("♥")
  val DIAMOND = EnumSuite("♦")
  val SPADE = Suite("♠")
}
// This way, there can only be 4 card suites since sealed classes cannot be instanciated elsewhere TODO check
Suites.CLUB != Suites.HEART // true