/*
 * #%L
 * ImageJ software for multidimensional image processing and analysis.
 * %%
 * Copyright (C) 2009 - 2018 Board of Regents of the University of
 * Wisconsin-Madison, Broad Institute of MIT and Harvard, and Max Planck
 * Institute of Molecular Cell Biology and Genetics.
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

package net.imagej.legacy.convert.roi.point;

import net.imagej.legacy.convert.roi.AbstractMaskPredicateToRoiConverter;
import net.imglib2.roi.geom.real.WritableRealPointCollection;
import net.imglib2.roi.util.RealLocalizableRealPositionable;

import org.scijava.convert.Converter;
import org.scijava.plugin.Plugin;

import ij.gui.PointRoi;

/**
 * Converts a {@link WritableRealPointCollection} to a {@link PointRoi}. This
 * conversion may be lossy since PointRoi coordinates are stored as
 * {@code float}s.
 *
 * @author Alison Walter
 */
@Plugin(type = Converter.class)
public class WritableRealPointCollectionToPointRoiConverter extends
	AbstractMaskPredicateToRoiConverter<WritableRealPointCollection<RealLocalizableRealPositionable>, PointRoi>
{

	@Override
	public Class<PointRoi> getOutputType() {
		return PointRoi.class;
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class<WritableRealPointCollection<RealLocalizableRealPositionable>>
		getInputType()
	{
		return (Class) WritableRealPointCollection.class;
	}

	@Override
	public PointRoi convert(
		final WritableRealPointCollection<RealLocalizableRealPositionable> mask)
	{
		return new RealPointCollectionWrapper(mask);
	}

	@Override
	public boolean isLossy() {
		return true;
	}
}
