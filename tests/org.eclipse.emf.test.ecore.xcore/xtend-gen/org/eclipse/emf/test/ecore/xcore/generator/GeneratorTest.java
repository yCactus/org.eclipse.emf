package org.eclipse.emf.test.ecore.xcore.generator;

import com.google.inject.Inject;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xcore.XPackage;
import org.eclipse.emf.ecore.xcore.XcoreInjectorProvider;
import org.eclipse.emf.ecore.xcore.generator.XcoreGenerator;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = XcoreInjectorProvider.class)
@SuppressWarnings("all")
public class GeneratorTest {
  @Inject
  private ParseHelper<XPackage> parser;
  
  @Inject
  private XcoreGenerator xcoreGenerator;
  
  @Test
  public void testGenerator() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@GenModel(modelDirectory=\"Nowhere\")");
      _builder.newLine();
      _builder.append("package test");
      _builder.newLine();
      _builder.append("class X {}");
      _builder.newLine();
      final XPackage xPackage = this.parser.parse(_builder);
      InMemoryFileSystemAccess _inMemoryFileSystemAccess = new InMemoryFileSystemAccess();
      final InMemoryFileSystemAccess inmemFsa = _inMemoryFileSystemAccess;
      Resource _eResource = xPackage.eResource();
      this.xcoreGenerator.doGenerate(_eResource, inmemFsa);
      Map<String,CharSequence> _files = inmemFsa.getFiles();
      Set<String> _keySet = _files.keySet();
      String _string = _keySet.toString();
      Map<String,CharSequence> _files_1 = inmemFsa.getFiles();
      int _size = _files_1.size();
      Assert.assertEquals(_string, 8, _size);
      Map<String,CharSequence> _files_2 = inmemFsa.getFiles();
      String _plus = (IFileSystemAccess.DEFAULT_OUTPUT + "/test/util/TestSwitch.java");
      CharSequence _get = _files_2.get(_plus);
      Assert.assertNotNull(_get);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
