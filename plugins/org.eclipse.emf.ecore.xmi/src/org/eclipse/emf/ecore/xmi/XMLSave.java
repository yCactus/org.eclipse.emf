/**
 * <copyright>
 *
 * Copyright (c) 2002-2004 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: XMLSave.java,v 1.4 2005/03/15 16:25:10 elena Exp $
 */
package org.eclipse.emf.ecore.xmi;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.w3c.dom.Document;


/**
 * This defines the methods for the interface that XMLResourceImpl
 * uses to save the resource.
 */
public interface XMLSave 
{

  /**
   * This defines the methods for the interface used to determine
   * whether type information should be saved when the
   * XMLResource.OPTION_SAVE_TYPE_INFORMATION save option is enabled.
   */
  interface XMLTypeInfo
  {

    /**
     * Determines whether type information should be saved for an object of the
     * specified type in a feature of the specified type.
     * 
     * @param objectType The object's type.
     * @param featureType The feature's type.
     * @param feature The feature in which the object is stored.
     * @return <code>true</code> if the type should be saved; <code>false</code>
     *         otherwise.
     */
    boolean shouldSaveType(EClass objectType, EClassifier featureType, EStructuralFeature feature);

    /**
     * Determines whether type information should be saved for an object of the
     * specified type in a feature of the specified type.
     * 
     * @param objectType The object's type.
     * @param featureType The feature's type.
     * @param feature The feature in which the object is stored.
     * @return <code>true</code> if the type should be saved; <code>false</code>
     *         otherwise.
     */
    boolean shouldSaveType(EClass objectType, EClass featureType, EStructuralFeature feature);

  }

  void save(XMLResource resource, OutputStream outputStream, Map options) throws IOException;

  /**
   * @param resource a resource 
   * @param document a {@link org.w3c.dom.Document} (must not be null)
   * @param handler a {@link DOMHandler} (must not be null)
   * @param options options
   * @return the document
   * @since 2.1.0
   */
  Document toDOM(XMLResource resource, Document document, DOMHandler handler, Map options);
}
