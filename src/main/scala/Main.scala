import scala.util.CommandLineParser.FromString.given_FromString_Int
@main def main: Unit =
  val dataBase = setUpDataBase

def setUpDataBase: DataBase =
  val names = Seq("代理店1号", "代理店2号", "代理店3号")
  var tmpDataBase = DataBase.initialize
  SalesRoute.addAgents(names*)(using tmpDataBase)
