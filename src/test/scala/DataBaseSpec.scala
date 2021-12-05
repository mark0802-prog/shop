class DataBaseSpec extends UnitSpec:
  trait context:
    val dataBase = DataBase.initialize
    val directSale = SalesRoute.Direct()

  "#initialize" should {
    "顧客情報は空で初期化される" in new context:
      assert(dataBase.customers.isEmpty)

    "販売経路は直販のみで初期化される" in new context:
      assertResult(Seq(directSale)) { dataBase.salesRoutes }
  }

  "#addCustomers" should {
    "顧客情報を追加できる" in new context:
      (pending)
  }

  "#addAgents" should {
    "販売経路（代理店）を追加できる" in new context:
      val name = "test"
      val agent = SalesRoute.Agent(name)
      val updatedDataBase = dataBase.addAgents(agent)
      assertResult(Seq(directSale, agent)) { updatedDataBase.salesRoutes }

    "販売経路（代理店）を複数追加できる" in new context:
      val names = Seq("代理店1号", "代理店2号", "代理店3号")
      val agents = names.map(name => SalesRoute.Agent(name))
      val updatedDataBase = dataBase.addAgents(agents*)
      assertResult(directSale +: agents) { updatedDataBase.salesRoutes }

  }
