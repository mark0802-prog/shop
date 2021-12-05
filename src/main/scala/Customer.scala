sealed trait Customer:
  val name: String

object Customer:
  case class Direct(name: String) extends Customer
  case class Agent(name: String, agentName: String)(using dataBase: DataBase)
      extends Customer:
    require(dataBase.salesRoutes.contains(agentName))
