package xyz.pisoj.holo1.model

import java.security.InvalidParameterException

data class DnsRecord(
    val name: String,
    val data: String,
    val type: DnsRecordType,
    val ttl: Int,
) {
    constructor(name: String, data: String, typeId: Int, ttl: Int) : this(name, data, DnsRecordType.byTypeId(typeId), ttl)
}

enum class DnsRecordType(val typeId: Int) {
    ANY(255),
    A(1),
    AAAA(28),
    AFSDB(18),
    APL(42),
    CAA(257),
    CDNSKEY(60),
    CDS(59),
    CERT(37),
    CNAME(5),
    CSYNC(62),
    DHCID(49),
    DLV(32769),
    DNAME(39),
    DNSKEY(48),
    DS(43),
    EUI48(108),
    EUI64(109),
    HINFO(13),
    HIP(55),
    HTTPS(65),
    IPSECKEY(45),
    KEY(25),
    KX(36),
    LOC(29),
    MX(15),
    NAPTR(35),
    NS(2),
    NSEC(47),
    NSEC3(50),
    NSEC3PARAM(51),
    OPENPGPKEY(61),
    PTR(12),
    RRSIG(46),
    RP(17),
    SIG(24),
    SMIMEA(53),
    SOA(6),
    SRV(33),
    SSHFP(44),
    SVCB(64),
    TA(32768),
    TKEY(249),
    TLSA(52),
    TSIG(250),
    TXT(16),
    URI(256),
    ZONEMD(63);

    companion object {
        fun byTypeId(typeId: Int): DnsRecordType {
            return DnsRecordType.entries.find { it.typeId == typeId } ?: throw InvalidParameterException("Invalid record type id.")
        }
    }
}
