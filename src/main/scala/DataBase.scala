case class DataBase(
    customers: Seq[Customer] = Nil,
    salesRoutes: Seq[SalesRoute] = Seq(SalesRoute.Direct())
):
  def addAgents(agents: SalesRoute.Agent*): DataBase =
    DataBase(customers, salesRoutes :++ agents)
