package com.registros.formularios.com.registros.formularios.auth;

public class JwtConfig {
    public static final String LLAVE_SECRETA = "MiLlavePrivada2019!.";

    public static final String RSA_PRIVATE = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEowIBAAKCAQEAq1etEoSiuZSRkrQBivr7VwVlC/+PzPWiNTrU7Hdo31BwtBfX\n" +
            "V9naZ22KmW96oozTOTmIzZ0QY1vEhfVYisppo0ILaDm9ifCoViHJP7HJK/wSMU6k\n" +
            "dOVUzNsz+XiLjKNiaNPzY1bWBIV4/N9Y3HaiVICenUmiZMSFKuSawON9JAuf4SlT\n" +
            "FK7HwGNYpMb+qzAsowRaK6L/+K+x1KXVH3Xsw9IZgdtT9+W36u4N0Kmolr2WimCo\n" +
            "vPvG/3Z3PKvVz0ypdOP1/7R48JLXqnin/SXhN4bO9CeP5C8KN2Lc8t46XxMYB55B\n" +
            "Oq09Bq4HClh8DNhkSTZF3+cRmM8HlWK7cc6BBwIDAQABAoIBAD/1qpWPDW9ZFj49\n" +
            "E5ZduhTx3pZr/7Hyv2o/W9wpduxliqyveaNBn1WcfnBoPM8Q4ogqAfc++i8cwm9+\n" +
            "9l5Y0LYwoTF23Fnxi+UbF5S/OOlCX0gooxs/wDf4W550cSM+mi2ncONUNu/ZIyDB\n" +
            "/tnNLyt8F7l/Ey+qbEtmqp32TXB2iYsfCUCsSUrHTDiLc0FAwCR7EBThP3VeCro8\n" +
            "3VSsgDppfKFu2fVgBNONM53deTJQgGkO4pj5BhQBsY4NWUfmPnZyl+3eIEcWcNjR\n" +
            "tmNDh3AbonYG7M6yVMMA3OrH3dPiJqTnBTHqiEdfuTrKK0i0voZ2Pouprxdv/1hP\n" +
            "hAtGFIECgYEA4uMt8Hp9BpSs4LI2wUgQDrqZC6rdobW6ON1R3JsZv/lYnXYqWyh/\n" +
            "UWID/GT0R8Ctunv4ufeMkxzkdBNjO1pfWx5vgHasDTLgsp06bH6H2lw1soXKtPgO\n" +
            "uI4Jxd68TwUpw05t4SrZkEOQfKLOOnqCBAAAC2qa3T3QX6Wkq6FgY/UCgYEAwVPz\n" +
            "eF8IoUkBvRj980AXOnvOtk9dhDLpaqXgsy9ezXN6FKCVZOzuPybHgKVK/IxKmVG4\n" +
            "WCtx5Dg2iZwm34zf2FWbUd4w9VBLQobwDRCDIESZFDWsWseiteVlexRq1B96jL0Q\n" +
            "dTtchpF483C2j7swoPbJWL41/cL6ZjeU6Yb9b4sCgYEAxjjmxOeu3ZX9J95rehfk\n" +
            "d4nM9mWUdpiXluC9iXg0WgWVxxQa00OhYE+63cKxrRKIdZmj542AUnL2oPbjRlKh\n" +
            "ZrFDhz+m920Q5Nv61BkDxeGzxEGhpNPnwJPPtADyEjOXlhuqYgOWyrRMwqdWd77a\n" +
            "YnZBk7fSjyJXL4k/QfeeiBUCgYBOpb1lWZvkKRQY/mLJI2iPtTApwG21yxRj+2lG\n" +
            "292ATRr76zv7W9usOzVr41J3HQd4CeOpkrr5cdjV8H1r8h5aHrFaA778/RYw0T40\n" +
            "wmPlq6Jus0sTfyV1RAYdpPe0pb2wJXXdizGf2OxQdKkAHdGxmdPdUzwZqMk+7huZ\n" +
            "SP4u8wKBgDiH0+XrL22rPYQpM3vBjKbPG/8SXdR2p0vN+e5iUeBN9qttR1CaMCB8\n" +
            "LSct+KHp1N041ZMkT0jm1BL1pR38OB3BLZOonFJ1hkung121GwaGqIOgp9ext23u\n" +
            "uWwi4o+017jwrk7tAOjaMBTgjm8XdE9qAyGaPBF5aQZe1kdI+lJ5\n" +
            "-----END RSA PRIVATE KEY-----";

    public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq1etEoSiuZSRkrQBivr7\n" +
            "VwVlC/+PzPWiNTrU7Hdo31BwtBfXV9naZ22KmW96oozTOTmIzZ0QY1vEhfVYispp\n" +
            "o0ILaDm9ifCoViHJP7HJK/wSMU6kdOVUzNsz+XiLjKNiaNPzY1bWBIV4/N9Y3Hai\n" +
            "VICenUmiZMSFKuSawON9JAuf4SlTFK7HwGNYpMb+qzAsowRaK6L/+K+x1KXVH3Xs\n" +
            "w9IZgdtT9+W36u4N0Kmolr2WimCovPvG/3Z3PKvVz0ypdOP1/7R48JLXqnin/SXh\n" +
            "N4bO9CeP5C8KN2Lc8t46XxMYB55BOq09Bq4HClh8DNhkSTZF3+cRmM8HlWK7cc6B\n" +
            "BwIDAQAB\n" +
            "-----END PUBLIC KEY-----";
}
