/*
* generated by Xtext
*/
package org.eclipse.emf.ecore.xcore;

import org.eclipse.xtext.junit4.IInjectorProvider;

import com.google.inject.Injector;

public class XcoreUiInjectorProvider implements IInjectorProvider {
	
	public Injector getInjector() {
		return org.eclipse.emf.ecore.xcore.ui.internal.XcoreActivator.getInstance().getInjector("org.eclipse.emf.ecore.xcore.Xcore");
	}
	
}
