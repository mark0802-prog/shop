@main def main: Unit =
  val dataBase =
    val names = Seq("代理店1号", "代理店2号", "代理店3号")
    implicit var tmpDataBase = DataBase()
    SalesRoute.addAgents(names*)
    tmpDataBase
