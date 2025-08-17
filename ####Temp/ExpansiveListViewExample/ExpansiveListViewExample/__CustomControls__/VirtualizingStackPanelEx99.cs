using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;

namespace ExpansiveListViewExample
{
    public sealed class VirtualizingStackPanelEx99 : VirtualizingStackPanel
    {
        private static void PrintOut(string msg)
        {
            Debug.WriteLine(msg);
        }


        public VirtualizingStackPanelEx99()
        {
        }

        public override void OnApplyTemplate()
        {
            //PrintOut("OnApplyTemplate");

            base.OnApplyTemplate();            
        }


        protected override Size ArrangeOverride(Size asz)
        {
            //PrintOut("ArrangeOverride");

            return base.ArrangeOverride(asz);
        }

        protected override double GetItemOffsetCore(UIElement child)
        {
            //PrintOut("GetItemOffsetCore");

            return base.GetItemOffsetCore(child);
        }

        protected override Size MeasureOverride(Size constraint)
        {
            //PrintOut("MeasureOverride");

            return base.MeasureOverride(constraint);
        }

        protected override void OnCleanUpVirtualizedItem(CleanUpVirtualizedItemEventArgs e)
        {
            //PrintOut("OnCleanUpVirtualizedItem");

            base.OnCleanUpVirtualizedItem(e);
        }

        protected override void OnClearChildren()
        {
            //PrintOut("OnClearChildren");

            base.OnClearChildren();
        }

        protected override void OnItemsChanged(object sender, ItemsChangedEventArgs args)
        {
            //PrintOut("OnItemsChanged");

            base.OnItemsChanged(sender, args);
        }

        protected override void OnViewportOffsetChanged(Vector oldViewportOffset, Vector newViewportOffset)
        {
            PrintOut("OnViewportOffsetChanged");

            //base.OnViewportOffsetChanged(oldViewportOffset, newViewportOffset);
        }

        protected override void OnViewportSizeChanged(Size oldViewportSize, Size newViewportSize)
        {
            //PrintOut("OnViewportSizeChanged");

            base.OnViewportSizeChanged(oldViewportSize, newViewportSize);
        }

        protected override bool ShouldItemsChangeAffectLayoutCore(bool areItemChangesLocal, ItemsChangedEventArgs args)
        {
            //PrintOut("ShouldItemsChangeAffectLayoutCore");

            return base.ShouldItemsChangeAffectLayoutCore(areItemChangesLocal, args);
        }

        protected override void BringIndexIntoView(int index)
        {
            //PrintOut("BringIndexIntoView");

            base.BringIndexIntoView(index);
        }
    }
}
