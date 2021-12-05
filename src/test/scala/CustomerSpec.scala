class CustomerSpec extends UnitSpec:
  trait context:
    given DataBase = DataBase.initialize
    val directSale = SalesRoute.Direct

  "#apply" should {
    "データベースに登録されていない代理店の顧客は作成できない" in new context:
      an[IllegalArgumentException] must be thrownBy {
        val name = "test"
        val notExistsAgent = "none"
        val agent: SalesRoute.Agent = SalesRoute.Agent(name)
        Customer.Agent(name, notExistsAgent)
      }
  }
