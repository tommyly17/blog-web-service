/**
 * ArticlesSOAP.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uts.wsd.soap.client;

public interface ArticlesSOAP extends java.rmi.Remote {
    public uts.wsd.soap.client.Article[] fetchArticles() throws java.rmi.RemoteException;
    public uts.wsd.soap.client.Article fetchArticle(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String listArticles() throws java.rmi.RemoteException;
    public void deleteArticle(java.lang.String arg0) throws java.rmi.RemoteException;
}
