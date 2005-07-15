/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: TestUtil.java,v 1.7 2005/07/15 22:50:01 nickb Exp $
 */
package org.eclipse.emf.test.performance;

import java.io.File;
import java.net.URL;

//import org.eclipse.core.runtime.Platform;

public class TestUtil
{
  private static final String PLUGIN_ID = "org.eclipse.emf.test.performance";
  private static final String CLASS_FILE = "org/eclipse/emf/test/performance/TestUtil.class";
  
  private static int runningUnderEclipseFlag = -1;
  
  public final static String getPluginDirectory()
  {
    try
    {
      //return new File(Platform.asLocalURL(EMFTestPerformancePlugin.getPlugin().getBundle().getEntry("/")).getFile()).toString();
      return new File(".").getCanonicalPath();
    }
    catch (Throwable t)
    {
    }

    URL url = ClassLoader.getSystemResource(CLASS_FILE);
    if (url != null)
    {
      String path = url.getPath();
      path = path.substring(0, path.indexOf(PLUGIN_ID));
      if (path.startsWith("file:"))
      {
        path = path.substring("file:".length());
      }
      File parentDir = new File(path);
      if (parentDir.isDirectory())
      {
        File[] files = parentDir.listFiles();
        for (int i = 0, maxi = files.length; i < maxi; i++)
        {
          if (files[i].isDirectory() && files[i].getName().startsWith(PLUGIN_ID))
          {
            return files[i].getAbsolutePath();
          }
        }
      }
    }

    return null;
  }
  
  public final static boolean isRunningUnderEclipse()
  {
//    if (runningUnderEclipseFlag == -1)
//    {
//      runningUnderEclipseFlag = 0; 
//      try
//      {
//        if (Platform.isRunning()) runningUnderEclipseFlag = 1;
//      }
//      catch (Throwable t)
//      {
//      }
//    }
//    return (runningUnderEclipseFlag == 1);
    return true;
  }
}
