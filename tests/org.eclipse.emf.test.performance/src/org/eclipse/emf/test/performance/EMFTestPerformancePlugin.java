/**
 * <copyright>
 *
 * Copyright (c) 2002-2005 IBM Corporation and others.
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
 * $Id: EMFTestPerformancePlugin.java,v 1.10 2005/02/17 18:55:50 marcelop Exp $
 */
package org.eclipse.emf.test.performance;

import org.eclipse.core.runtime.Plugin;

public class EMFTestPerformancePlugin 
extends Plugin
{
    private static EMFTestPerformancePlugin instance;
    
    public EMFTestPerformancePlugin()
    {
        super();
        instance = this;
        
        try
        {
          if (Class.forName("org.apache.derby.drda.NetworkServerControl") != null)
          {
            System.out.println("*** Derby is in the classpath.");
            System.setProperty("test.target", "performance");
            System.setProperty("eclipse.perf.dbloc", "net://localhost;dbuser=app;dbpasswd=app");
            System.setProperty("eclipse.perf.config" ,"build=fromJava");
          }
        }
        catch (ClassNotFoundException e)
        {
        }
    }

    public static EMFTestPerformancePlugin getPlugin()
    {
        return instance;
    }
}
