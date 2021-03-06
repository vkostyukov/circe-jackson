package io.circe.jackson

import io.circe.Json

class JacksonPrintingSuite extends CirceSuite with JacksonInstances {
  "jacksonPrint" should "produce round-trippable output" in forAll(arbitraryCleanedJson.arbitrary) { (json: Json) =>
    assert(io.circe.jawn.parse(jacksonPrint(json)) === Right(json))
  }
}
