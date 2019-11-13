// 
// Decompiled by Procyon v0.5.36
// 

package org.w3._2000._09.xmldsig;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory
{
    private static final QName _PGPData_QNAME;
    private static final QName _SPKIData_QNAME;
    private static final QName _RetrievalMethod_QNAME;
    private static final QName _CanonicalizationMethod_QNAME;
    private static final QName _SignatureProperty_QNAME;
    private static final QName _Manifest_QNAME;
    private static final QName _Transforms_QNAME;
    private static final QName _SignatureMethod_QNAME;
    private static final QName _KeyInfo_QNAME;
    private static final QName _DigestMethod_QNAME;
    private static final QName _MgmtData_QNAME;
    private static final QName _Reference_QNAME;
    private static final QName _RSAKeyValue_QNAME;
    private static final QName _Signature_QNAME;
    private static final QName _DSAKeyValue_QNAME;
    private static final QName _SignedInfo_QNAME;
    private static final QName _Object_QNAME;
    private static final QName _SignatureValue_QNAME;
    private static final QName _Transform_QNAME;
    private static final QName _X509Data_QNAME;
    private static final QName _DigestValue_QNAME;
    private static final QName _SignatureProperties_QNAME;
    private static final QName _KeyName_QNAME;
    private static final QName _KeyValue_QNAME;
    private static final QName _SPKIDataTypeSPKISexp_QNAME;
    private static final QName _PGPDataTypePGPKeyID_QNAME;
    private static final QName _PGPDataTypePGPKeyPacket_QNAME;
    private static final QName _X509DataTypeX509IssuerSerial_QNAME;
    private static final QName _X509DataTypeX509Certificate_QNAME;
    private static final QName _X509DataTypeX509SKI_QNAME;
    private static final QName _X509DataTypeX509SubjectName_QNAME;
    private static final QName _X509DataTypeX509CRL_QNAME;
    private static final QName _SignatureMethodTypeHMACOutputLength_QNAME;
    private static final QName _TransformTypeXPath_QNAME;
    
    public KeyInfoType createKeyInfoType() {
        return new KeyInfoType();
    }
    
    public SignedInfoType createSignedInfoType() {
        return new SignedInfoType();
    }
    
    public RetrievalMethodType createRetrievalMethodType() {
        return new RetrievalMethodType();
    }
    
    public DigestMethodType createDigestMethodType() {
        return new DigestMethodType();
    }
    
    public SignatureMethodType createSignatureMethodType() {
        return new SignatureMethodType();
    }
    
    public SPKIDataType createSPKIDataType() {
        return new SPKIDataType();
    }
    
    public X509DataType createX509DataType() {
        return new X509DataType();
    }
    
    public PGPDataType createPGPDataType() {
        return new PGPDataType();
    }
    
    public SignatureType createSignatureType() {
        return new SignatureType();
    }
    
    public DSAKeyValueType createDSAKeyValueType() {
        return new DSAKeyValueType();
    }
    
    public ManifestType createManifestType() {
        return new ManifestType();
    }
    
    public SignatureValueType createSignatureValueType() {
        return new SignatureValueType();
    }
    
    public TransformsType createTransformsType() {
        return new TransformsType();
    }
    
    public RSAKeyValueType createRSAKeyValueType() {
        return new RSAKeyValueType();
    }
    
    public TransformType createTransformType() {
        return new TransformType();
    }
    
    public SignaturePropertyType createSignaturePropertyType() {
        return new SignaturePropertyType();
    }
    
    public KeyValueType createKeyValueType() {
        return new KeyValueType();
    }
    
    public ReferenceType createReferenceType() {
        return new ReferenceType();
    }
    
    public CanonicalizationMethodType createCanonicalizationMethodType() {
        return new CanonicalizationMethodType();
    }
    
    public SignaturePropertiesType createSignaturePropertiesType() {
        return new SignaturePropertiesType();
    }
    
    public ObjectType createObjectType() {
        return new ObjectType();
    }
    
    public X509IssuerSerialType createX509IssuerSerialType() {
        return new X509IssuerSerialType();
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "PGPData")
    public JAXBElement<PGPDataType> createPGPData(final PGPDataType pgpDataType) {
        return new JAXBElement<PGPDataType>(ObjectFactory._PGPData_QNAME, PGPDataType.class, null, pgpDataType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "SPKIData")
    public JAXBElement<SPKIDataType> createSPKIData(final SPKIDataType spkiDataType) {
        return new JAXBElement<SPKIDataType>(ObjectFactory._SPKIData_QNAME, SPKIDataType.class, null, spkiDataType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "RetrievalMethod")
    public JAXBElement<RetrievalMethodType> createRetrievalMethod(final RetrievalMethodType retrievalMethodType) {
        return new JAXBElement<RetrievalMethodType>(ObjectFactory._RetrievalMethod_QNAME, RetrievalMethodType.class, null, retrievalMethodType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "CanonicalizationMethod")
    public JAXBElement<CanonicalizationMethodType> createCanonicalizationMethod(final CanonicalizationMethodType canonicalizationMethodType) {
        return new JAXBElement<CanonicalizationMethodType>(ObjectFactory._CanonicalizationMethod_QNAME, CanonicalizationMethodType.class, null, canonicalizationMethodType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "SignatureProperty")
    public JAXBElement<SignaturePropertyType> createSignatureProperty(final SignaturePropertyType signaturePropertyType) {
        return new JAXBElement<SignaturePropertyType>(ObjectFactory._SignatureProperty_QNAME, SignaturePropertyType.class, null, signaturePropertyType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "Manifest")
    public JAXBElement<ManifestType> createManifest(final ManifestType manifestType) {
        return new JAXBElement<ManifestType>(ObjectFactory._Manifest_QNAME, ManifestType.class, null, manifestType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "Transforms")
    public JAXBElement<TransformsType> createTransforms(final TransformsType transformsType) {
        return new JAXBElement<TransformsType>(ObjectFactory._Transforms_QNAME, TransformsType.class, null, transformsType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "SignatureMethod")
    public JAXBElement<SignatureMethodType> createSignatureMethod(final SignatureMethodType signatureMethodType) {
        return new JAXBElement<SignatureMethodType>(ObjectFactory._SignatureMethod_QNAME, SignatureMethodType.class, null, signatureMethodType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "KeyInfo")
    public JAXBElement<KeyInfoType> createKeyInfo(final KeyInfoType keyInfoType) {
        return new JAXBElement<KeyInfoType>(ObjectFactory._KeyInfo_QNAME, KeyInfoType.class, null, keyInfoType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "DigestMethod")
    public JAXBElement<DigestMethodType> createDigestMethod(final DigestMethodType digestMethodType) {
        return new JAXBElement<DigestMethodType>(ObjectFactory._DigestMethod_QNAME, DigestMethodType.class, null, digestMethodType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "MgmtData")
    public JAXBElement<String> createMgmtData(final String s) {
        return new JAXBElement<String>(ObjectFactory._MgmtData_QNAME, String.class, null, s);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "Reference")
    public JAXBElement<ReferenceType> createReference(final ReferenceType referenceType) {
        return new JAXBElement<ReferenceType>(ObjectFactory._Reference_QNAME, ReferenceType.class, null, referenceType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "RSAKeyValue")
    public JAXBElement<RSAKeyValueType> createRSAKeyValue(final RSAKeyValueType rsaKeyValueType) {
        return new JAXBElement<RSAKeyValueType>(ObjectFactory._RSAKeyValue_QNAME, RSAKeyValueType.class, null, rsaKeyValueType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "Signature")
    public JAXBElement<SignatureType> createSignature(final SignatureType signatureType) {
        return new JAXBElement<SignatureType>(ObjectFactory._Signature_QNAME, SignatureType.class, null, signatureType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "DSAKeyValue")
    public JAXBElement<DSAKeyValueType> createDSAKeyValue(final DSAKeyValueType dsaKeyValueType) {
        return new JAXBElement<DSAKeyValueType>(ObjectFactory._DSAKeyValue_QNAME, DSAKeyValueType.class, null, dsaKeyValueType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "SignedInfo")
    public JAXBElement<SignedInfoType> createSignedInfo(final SignedInfoType signedInfoType) {
        return new JAXBElement<SignedInfoType>(ObjectFactory._SignedInfo_QNAME, SignedInfoType.class, null, signedInfoType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "Object")
    public JAXBElement<ObjectType> createObject(final ObjectType objectType) {
        return new JAXBElement<ObjectType>(ObjectFactory._Object_QNAME, ObjectType.class, null, objectType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "SignatureValue")
    public JAXBElement<SignatureValueType> createSignatureValue(final SignatureValueType signatureValueType) {
        return new JAXBElement<SignatureValueType>(ObjectFactory._SignatureValue_QNAME, SignatureValueType.class, null, signatureValueType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "Transform")
    public JAXBElement<TransformType> createTransform(final TransformType transformType) {
        return new JAXBElement<TransformType>(ObjectFactory._Transform_QNAME, TransformType.class, null, transformType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "X509Data")
    public JAXBElement<X509DataType> createX509Data(final X509DataType x509DataType) {
        return new JAXBElement<X509DataType>(ObjectFactory._X509Data_QNAME, X509DataType.class, null, x509DataType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "DigestValue")
    public JAXBElement<byte[]> createDigestValue(final byte[] array) {
        return new JAXBElement<byte[]>(ObjectFactory._DigestValue_QNAME, byte[].class, null, array);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "SignatureProperties")
    public JAXBElement<SignaturePropertiesType> createSignatureProperties(final SignaturePropertiesType signaturePropertiesType) {
        return new JAXBElement<SignaturePropertiesType>(ObjectFactory._SignatureProperties_QNAME, SignaturePropertiesType.class, null, signaturePropertiesType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "KeyName")
    public JAXBElement<String> createKeyName(final String s) {
        return new JAXBElement<String>(ObjectFactory._KeyName_QNAME, String.class, null, s);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "KeyValue")
    public JAXBElement<KeyValueType> createKeyValue(final KeyValueType keyValueType) {
        return new JAXBElement<KeyValueType>(ObjectFactory._KeyValue_QNAME, KeyValueType.class, null, keyValueType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "SPKISexp", scope = SPKIDataType.class)
    public JAXBElement<byte[]> createSPKIDataTypeSPKISexp(final byte[] array) {
        return new JAXBElement<byte[]>(ObjectFactory._SPKIDataTypeSPKISexp_QNAME, byte[].class, SPKIDataType.class, array);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "PGPKeyID", scope = PGPDataType.class)
    public JAXBElement<byte[]> createPGPDataTypePGPKeyID(final byte[] array) {
        return new JAXBElement<byte[]>(ObjectFactory._PGPDataTypePGPKeyID_QNAME, byte[].class, PGPDataType.class, array);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "PGPKeyPacket", scope = PGPDataType.class)
    public JAXBElement<byte[]> createPGPDataTypePGPKeyPacket(final byte[] array) {
        return new JAXBElement<byte[]>(ObjectFactory._PGPDataTypePGPKeyPacket_QNAME, byte[].class, PGPDataType.class, array);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "X509IssuerSerial", scope = X509DataType.class)
    public JAXBElement<X509IssuerSerialType> createX509DataTypeX509IssuerSerial(final X509IssuerSerialType x509IssuerSerialType) {
        return new JAXBElement<X509IssuerSerialType>(ObjectFactory._X509DataTypeX509IssuerSerial_QNAME, X509IssuerSerialType.class, X509DataType.class, x509IssuerSerialType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "X509Certificate", scope = X509DataType.class)
    public JAXBElement<byte[]> createX509DataTypeX509Certificate(final byte[] array) {
        return new JAXBElement<byte[]>(ObjectFactory._X509DataTypeX509Certificate_QNAME, byte[].class, X509DataType.class, array);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "X509SKI", scope = X509DataType.class)
    public JAXBElement<byte[]> createX509DataTypeX509SKI(final byte[] array) {
        return new JAXBElement<byte[]>(ObjectFactory._X509DataTypeX509SKI_QNAME, byte[].class, X509DataType.class, array);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "X509SubjectName", scope = X509DataType.class)
    public JAXBElement<String> createX509DataTypeX509SubjectName(final String s) {
        return new JAXBElement<String>(ObjectFactory._X509DataTypeX509SubjectName_QNAME, String.class, X509DataType.class, s);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "X509CRL", scope = X509DataType.class)
    public JAXBElement<byte[]> createX509DataTypeX509CRL(final byte[] array) {
        return new JAXBElement<byte[]>(ObjectFactory._X509DataTypeX509CRL_QNAME, byte[].class, X509DataType.class, array);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "HMACOutputLength", scope = SignatureMethodType.class)
    public JAXBElement<BigInteger> createSignatureMethodTypeHMACOutputLength(final BigInteger bigInteger) {
        return new JAXBElement<BigInteger>(ObjectFactory._SignatureMethodTypeHMACOutputLength_QNAME, BigInteger.class, SignatureMethodType.class, bigInteger);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "XPath", scope = TransformType.class)
    public JAXBElement<String> createTransformTypeXPath(final String s) {
        return new JAXBElement<String>(ObjectFactory._TransformTypeXPath_QNAME, String.class, TransformType.class, s);
    }
    
    static {
        _PGPData_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "PGPData");
        _SPKIData_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "SPKIData");
        _RetrievalMethod_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "RetrievalMethod");
        _CanonicalizationMethod_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "CanonicalizationMethod");
        _SignatureProperty_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "SignatureProperty");
        _Manifest_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "Manifest");
        _Transforms_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "Transforms");
        _SignatureMethod_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "SignatureMethod");
        _KeyInfo_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "KeyInfo");
        _DigestMethod_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "DigestMethod");
        _MgmtData_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "MgmtData");
        _Reference_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "Reference");
        _RSAKeyValue_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "RSAKeyValue");
        _Signature_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "Signature");
        _DSAKeyValue_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "DSAKeyValue");
        _SignedInfo_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "SignedInfo");
        _Object_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "Object");
        _SignatureValue_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "SignatureValue");
        _Transform_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "Transform");
        _X509Data_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "X509Data");
        _DigestValue_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "DigestValue");
        _SignatureProperties_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "SignatureProperties");
        _KeyName_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "KeyName");
        _KeyValue_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "KeyValue");
        _SPKIDataTypeSPKISexp_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "SPKISexp");
        _PGPDataTypePGPKeyID_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "PGPKeyID");
        _PGPDataTypePGPKeyPacket_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "PGPKeyPacket");
        _X509DataTypeX509IssuerSerial_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "X509IssuerSerial");
        _X509DataTypeX509Certificate_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "X509Certificate");
        _X509DataTypeX509SKI_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "X509SKI");
        _X509DataTypeX509SubjectName_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "X509SubjectName");
        _X509DataTypeX509CRL_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "X509CRL");
        _SignatureMethodTypeHMACOutputLength_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "HMACOutputLength");
        _TransformTypeXPath_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "XPath");
    }
}
